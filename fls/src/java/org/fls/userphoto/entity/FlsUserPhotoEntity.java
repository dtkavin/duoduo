/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.userphoto.entity;

import java.sql.Blob;
import org.fls.user.entity.FlsUserEntity;

/**
 *用户照片处理
 * @author Tone
 */
public class FlsUserPhotoEntity {

    private String photo_id;
    private FlsUserEntity photo_owner;
    private Blob photo_blob;

    /**
     * @return the photo_id
     */
    public String getPhoto_id() {
       
        return photo_id;
    }

    /**
     * @param photo_id the photo_id to set
     */
    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    /**
     * @return the photo_owner
     */
    public FlsUserEntity getPhoto_owner() {
        return photo_owner;
    }

    /**
     * @param photo_owner the photo_owner to set
     */
    public void setPhoto_owner(FlsUserEntity photo_owner) {
        this.photo_owner = photo_owner;
    }

    /**
     * @return the photo_blob
     */
    public Blob getPhoto_blob() {
        return photo_blob;
    }

    /**
     * @param photo_blob the photo_blob to set
     */
    public void setPhoto_blob(Blob photo_blob) {
        this.photo_blob = photo_blob;
    }
}
