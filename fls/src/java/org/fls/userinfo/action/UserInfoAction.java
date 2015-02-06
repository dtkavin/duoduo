/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.userinfo.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.user.entity.FlsUserEntity;
import org.fls.userinfo.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.apache.commons.io.FileUtils;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.utils.DesUtils;
import org.fls.common.utils.HotCountUtil;
import org.fls.common.utils.PageUtils;
import org.fls.reply.entity.FlsReplyEntity;
import org.fls.reply.service.ReplyService;
import org.fls.userphoto.entity.FlsUserPhotoEntity;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;

/**
 * 用户信息相关操作控制类
 *
 * @author Tone
 */
@Controller("UserInfoAction")
@Scope("session")
public class UserInfoAction extends AbstractFlsBaseAction {

    private Map<String, Object> session;
    private Map<String, Object> request;
    @Resource
    private UserInfoService userInfoService;//用户信息操作实现类
    private FlsPageEntity pageEntity; //分页容器
    private int pageSize = 10;   // 页大小
    private int currentPage;//当前页
    //用于文件上传
    private File image;
    private String imageFileName;

    /**
     * 更新用户的头像
     *
     * @return String
     * @throws Exception
     */
    public String editUserPohto() throws Exception {
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);
        FlsUserEntity userEntity_db = userInfoService.getUserInfoByID(userEntity_session.getUser_id());

        String realPath = ServletActionContext.getServletContext().getRealPath("/Images/faces");
        String userID = userEntity_session.getUser_id();


        // setImageFileName(userID + "_" + getImageFileName());
        setImageFileName(userID + getImageFileName().substring(getImageFileName().indexOf("."), getImageFileName().length()));
        // System.out.println("imageFileName:" + getImageFileName());
        if (getImage() != null) {

            File saveFile = new File(new File(realPath), getImageFileName());
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            FileUtils.copyFile(getImage(), saveFile);
            userEntity_db.setUser_imageurl(getImageFileName());

            FileInputStream fileInputStream = new FileInputStream(saveFile);
            FlsUserPhotoEntity userPhotoEntity = userEntity_db.getUser_photo();
            if (userPhotoEntity == null) {
                userPhotoEntity = new FlsUserPhotoEntity();
            }
            userPhotoEntity.setPhoto_owner(userEntity_db);
            userPhotoEntity.setPhoto_blob(Hibernate.createBlob(fileInputStream));
            userEntity_db.setUser_photo(userPhotoEntity);
            userInfoService.updateUserInfo(userEntity_db);
        }



        // 保存到本地

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(image));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(realPath + File.separator + getImageFileName()));

            byte[] buf = new byte[(int) image.length()];
            int len = 0;
            while ((len = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }

        this.session.put("LOGIN_USER", userEntity_db);
        this.request.put("imageurl", userEntity_db.getUser_imageurl());
        this.request.put("viewuser_imageuserid", userEntity_db.getUser_id());

        return SUCCESS;
    }
    private String viewuser_id;
    private String viewflag;

    /**
     * 查看用户信息 默认查看用户已经发布的帖子
     *
     * @return String
     * @throws Exception
     */
    public String viewUserInfo() throws Exception {
        //当前登录用户
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);
        //查看的目标用户
        FlsUserEntity userEntity_db = userInfoService.viewUserInfo(viewuser_id, userEntity_session.getUser_id());


        //查询出用户已经发布的帖子  已经做分页处理
        this.setPageEntity(userInfoService.queryThemeForPage(getPageSize(), getCurrentPage(), viewuser_id));

        this.request.put("viewuser", userEntity_db);
        //当前用户查看  更新session
        if (userEntity_session != null && viewuser_id.equals(userEntity_session.getUser_id())) {
            this.session.put(LOGIN_USER, userEntity_db);
        }

        return SUCCESS + "_viewuserinfo";
    }
    private String aboutme;//自我介绍
    private String wheretogo;//
    private String location;//
    private String gender;
    private String website;
    private String underwrite;
    private String province;
    private String city;
    private String area;

    /**
     * 保存用户信息
     *
     * @return String
     * @throws Exception
     */
    public String saveUserInfo() throws Exception {
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);

        FlsUserEntity userEntity_db = userInfoService.getUserInfoByID(userEntity_session.getUser_id());
        userEntity_db.setUser_aboutme(getAboutme());
        userEntity_db.setUser_wheretogo(getWheretogo());

        userEntity_db.setUser_gender(getGender());
        userEntity_db.setUser_website(getWebsite());
        userEntity_db.setUser_underwrite(getUnderwrite());

        userEntity_db.setUser_location(getLocation());
        userEntity_db.setUser_province(getProvince());
        userEntity_db.setUser_city(getCity());
        userEntity_db.setUser_area(getArea());
        FlsMsgEntity msgEntity = userInfoService.updateUserInfo(userEntity_db);
        if (msgEntity.isFlag()) {
            this.session.put(LOGIN_USER, msgEntity.getLoginUser());
            this.setMessage(YESMSG, "个人信息修改成功");
            return SUCCESS + "_saveuserinfo";
        } else {
            this.setMessage(NOMSG, msgEntity.getMessage());
            return ERROR;
        }

    }

    /**
     * 查看粉丝
     *
     * @return String
     * @throws Exception
     */
    public String viewFuns() throws Exception {
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);

        FlsUserEntity userEntity_db = userInfoService.viewUserInfo(viewuser_id, userEntity_session.getUser_id());
        this.request.put("viewuser", userEntity_db);
        this.request.put("viewflag", viewflag);
        this.pageEntity = userInfoService.queryFunsForPage(pageSize, currentPage, viewuser_id, userEntity_session.getUser_id());


        return SUCCESS + "_viewfuns";

    }

    /**
     * 查看关注
     *
     * @return String
     * @throws Exception
     */
    public String viewFollws() throws Exception {
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);
        FlsUserEntity userEntity_db = userInfoService.viewUserInfo(viewuser_id, userEntity_session.getUser_id());
        this.request.put("viewuser", userEntity_db);
        this.request.put("viewflag", viewflag);
        this.pageEntity = userInfoService.queryFllowForPage(pageSize, currentPage, viewuser_id, userEntity_session.getUser_id());
        return SUCCESS + "_viewfuns";
    }

    /**
     * 查看回复
     *
     * @return String
     * @throws Exception
     */
    public String viewReply() throws Exception {

        FlsUserEntity userEntity_db = userInfoService.getUserInfoByID(viewuser_id);
        this.request.put("viewuser", userEntity_db);
        this.request.put("viewflag", viewflag);
        FlsPageEntity pageEntity_db = userInfoService.queryReplyForPage(pageSize, currentPage, viewuser_id);

        List<FlsReplyEntity> replys = (List<FlsReplyEntity>) pageEntity_db.getList();
        List<FlsReplyEntity> replys_new = new ArrayList<FlsReplyEntity>();
        for (FlsReplyEntity flsReplyEntity : replys) {


            flsReplyEntity.setCurrentPage_indexI(PageUtils.getPageIndex(pageSize, pageEntity_db.getAllRow(), flsReplyEntity.getReply_index()));

            replys_new.add(flsReplyEntity);
        }
        pageEntity_db.setList(replys_new);

        this.pageEntity = pageEntity_db;


        return SUCCESS + "_viewreply";

    }

    /**
     * 查看收藏
     *
     * @return String
     * @throws Exception
     */
    public String viewFave() throws Exception {
        FlsUserEntity userEntity_db = userInfoService.getUserInfoByID(viewuser_id);

        this.request.put("viewuser", userEntity_db);
        this.request.put("viewflag", viewflag);

        this.pageEntity = userInfoService.queryFaveForPage(pageSize, currentPage, viewuser_id);


        return SUCCESS + "_viewfave";

    }
    private String old_password;
    private String new_password;

    /**
     * 修改密码
     *
     * @return String
     * @throws Exception
     */
    public String chgpass() throws Exception {
        DesUtils desUtils = new DesUtils();
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get("LOGIN_USER");
        String password_old = desUtils.decrypt(userEntity_session.getUser_password());
        if (!password_old.equals(old_password)) {
            this.setMessage(NOMSG, "请核对输入的旧密码");
            return INPUT + "_chgpass";
        }
        FlsUserEntity userEntity_db = userInfoService.getUserInfoByID(userEntity_session.getUser_id());
        userEntity_db.setUser_password(desUtils.encrypt(new_password));

        FlsMsgEntity msgEntity = userInfoService.updateUserInfo(userEntity_db);


        if (msgEntity.isFlag()) {
            this.session.remove(LOGIN_USER);
            this.setMessage(YESMSG, "修改成功,请重新登录");
            return SUCCESS + "_chgpass";
        } else {
            this.setMessage(NOMSG, msgEntity.getMessage());
            return ERROR;
        }

    }

    @Override
    public void setMessage(String mesFalg, String message) {
        this.request.put(mesFalg, message);
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        //
    }

    /**
     * @return the pageEntity
     */
    public FlsPageEntity getPageEntity() {
        return pageEntity;
    }

    /**
     * @param pageEntity the pageEntity to set
     */
    public void setPageEntity(FlsPageEntity pageEntity) {
        this.pageEntity = pageEntity;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the viewuser_id
     */
    public String getViewuser_id() {
        return viewuser_id;
    }

    /**
     * @param viewuser_id the viewuser_id to set
     */
    public void setViewuser_id(String viewuser_id) {
        this.viewuser_id = viewuser_id;
    }

    /**
     * @return the viewflag
     */
    public String getViewflag() {
        return viewflag;
    }

    /**
     * @param viewflag the viewflag to set
     */
    public void setViewflag(String viewflag) {
        this.viewflag = viewflag;
    }

    /**
     * @return the image
     */
    public File getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(File image) {
        this.image = image;
    }

    /**
     * @return the imageFileName
     */
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * @param imageFileName the imageFileName to set
     */
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    /**
     * @return the aboutme
     */
    public String getAboutme() {
        return aboutme;
    }

    /**
     * @param aboutme the aboutme to set
     */
    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    /**
     * @return the wheretogo
     */
    public String getWheretogo() {
        return wheretogo;
    }

    /**
     * @param wheretogo the wheretogo to set
     */
    public void setWheretogo(String wheretogo) {
        this.wheretogo = wheretogo;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the underwrite
     */
    public String getUnderwrite() {
        return underwrite;
    }

    /**
     * @param underwrite the underwrite to set
     */
    public void setUnderwrite(String underwrite) {
        this.underwrite = underwrite;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the old_password
     */
    public String getOld_password() {
        return old_password;
    }

    /**
     * @param old_password the old_password to set
     */
    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    /**
     * @return the new_password
     */
    public String getNew_password() {
        return new_password;
    }

    /**
     * @param new_password the new_password to set
     */
    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}
