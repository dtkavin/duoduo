package org.bcsfll.common.utility;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 文件操作工具类
 * 
 * @author tone
 * 
 */
public class FileUtil {

	private final static String ENCODING = "GBK";

	/**
	 * 读取文件内容
	 * 
	 * @param file	文件对象
	 * @param fileEncoding	文件编码格式
	 * @return String类型的文件内容
	 */
	public static String readFileString(File file, String fileEncoding) {
		BufferedReader bufferedReader = null;
		StringBuffer buffer = new StringBuffer();
		if (!file.exists()) {
			return null;
		}
		if ("".equals(fileEncoding) || fileEncoding == null) {
			fileEncoding = ENCODING;
		}

		try {
			// bufferedReader=new BufferedReader(new FileReader(file));
			bufferedReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), fileEncoding));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				buffer.append(line);
			}
			bufferedReader.close();

			return buffer.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * 采取默认形式读取文件内容
	 * 
	 * @param file	文件对象
	 * @return String类型的文件内容
	 */
	public static String readFileString(File file) {
		return readFileString(file, null);
	}

	/**
	 * 采取默认形式读取文件内容
	 * 
	 * @param pathname	文件全路径名
	 * @return String类型的文件内容
	 */
	public static String readFileString(String pathname) {
		return readFileString(new File(pathname), null);
	}

	/**
	 * 读取文件内容
	 * 
	 * @param pathname	文件全路径名
	 * @param fileEncoding	文件编码格式
	 * @return String类型的文件内容
	 */
	public static String readFileString(String pathname, String fileEncoding) {
		return readFileString(new File(pathname), fileEncoding);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 读取文件的字节数据
	 * 
	 * @param file	文件类型对象
	 * @return 字节数据
	 */
	public static byte[] readFileByte(File file) {

		if (!file.exists()) {
			return null;
		}
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fileInputStream.read(buffer)) != -1) {

				byteArrayOutputStream.write(buffer, 0, len);
				// byteArrayOutputStream.write(buffer);

			}
			return byteArrayOutputStream.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 读取文件的字节数据
	 * 
	 * @param pathname	文件全路径名
	 * @return	字节数组
	 */
	public static byte[] readFileByte(String pathname) {
		return readFileByte(new File(pathname));
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 复制单独一个文件
	 * @param srcfile	源文件
	 * @param tagFile	目标文件
	 */
	private static void copyFile(File srcfile, File tagFile) {

		if (!srcfile.exists()) {
			return;
		}

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		
		if (!tagFile.exists()) {
			new File(tagFile.getParent()).mkdirs();
		}

		try {
			fileInputStream = new FileInputStream(srcfile);
			fileOutputStream = new FileOutputStream(tagFile);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fileInputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, len);
			}
			fileOutputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * 复制文件目录
	 * @param srcDir
	 * @param tagDir
	 */
	private static void copyDir(String srcDir, String tagDir) {
		File tagDirFile = new File(tagDir);
		if (!tagDirFile.exists()) {
			tagDirFile.mkdirs();
		}
		for (File srcFile : new File(srcDir).listFiles()) {
			if (srcFile.isFile()) {
				 File tagFile = new File(tagDirFile.getAbsolutePath() + File.separator + srcFile.getName());
				 copyFile(srcFile, tagFile);
			}else if (srcFile.isDirectory()) {
				String dirSrc = srcDir + File.separator+ srcFile.getName();
		        String dirBak = tagDir + File.separator+ srcFile.getName();
		        copyDir(dirSrc, dirBak);
			}
		}
	}
	/**
	 * 复制文件内容 包括目录结构
	 * @param srcfile	源文件夹
	 * @param tagFile	目标文件夹
	 */
	private static void copyFile(String srcPathName, String tagPathName) {
		 if (!new File(srcPathName).exists()) {
			return;
		 }
		 File tagFile = new File(tagPathName);
		 if (!tagFile.exists()&&(new File(srcPathName)).isDirectory()) {
			 
			tagFile.mkdirs();
		 }
		 if ((new File(srcPathName)).isFile()) {
			 
			 copyFile(new File(srcPathName), new File(tagPathName));
			 return;
		 }
		 
		 for (File srcFile : new File(srcPathName).listFiles()) {
			 if (srcFile.isFile()) {
				 copyFile(srcFile, new File(tagPathName + File.separator + srcFile.getName()));
			 }else if (srcFile.isDirectory()) {
				 String srcDir = srcPathName + File.separator + srcFile.getName();
			     String tagDir = tagPathName + File.separator + srcFile.getName();
			     copyDir(srcDir, tagDir);
			}
		 }
	}
	/**
	 * 复制文件
	 * @param srcPathName 源文件
	 * @param tagPathName 目标文件
	 * @param flag 追加目录或文件
	 */
	public static void copyFile(String srcPathName, String tagPathName ,boolean flag) {
		if (flag) {
			copyFile( srcPathName,  tagPathName+File.separator+new File(srcPathName).getName()); 
		}else {
			copyFile( srcPathName,  tagPathName);
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 删除一个目录及子目录 包括文件及目录结构
	 * @param srcfile	源文件夹
	 */
	public static void deleteFile(String  pathname) {
		
		File file=new File(pathname);
		if (!file.exists()) {
			return;
		}
		if (file.isFile()) {
			file.delete();
		}else if(file.isDirectory()) {
			for (String fileName:file.list()) {
				deleteFile(pathname+File.separator+fileName);
			}
			file.delete();
		}
		
	}
	/**
	 * 清理目录 但是不删除目录结构
	 * @param pathname
	 */
	public static void cleanDir(String  pathname) {
		
		File file=new File(pathname);
		if (!file.exists()) {
			return;
		}
		
		if (file.isFile()) {
			file.delete();
		}else if(file.isDirectory()) {
			for (String fileName:file.list()) {
				cleanDir(pathname+File.separator+fileName);
			}
		}	
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 根据后后缀名取得目录下的文件名集合 不包含子目录
	 * @param pathname	 目录全路径名称
	 * @param p_extName 后缀名数组
	 * @return
	 */
	public static ArrayList<String>  listFiles(String pathname, String p_extName[]){
		File srcFile=new File(pathname);
		
		if (!srcFile.exists()) {
			return null;
		}
		 ArrayList<String> fileNames = new ArrayList<String>();
		if (srcFile.isFile()) {
			
			if (p_extName==null||p_extName.length==0) {
				fileNames.add(new File(pathname).getName());
			}else {
				String suffix=getFileSuffix(srcFile);
				for (int i = 0; i < p_extName.length; i++) {
					if (p_extName[i].equalsIgnoreCase(suffix)) {
						fileNames.add(new File(pathname).getName());
						
					}
				}
			}
		}else if (srcFile.isDirectory()) {
			for (File file:srcFile.listFiles()) {
				if (!file.isFile()) {
					continue;
				}
				if (p_extName==null||p_extName.length==0) {
					fileNames.add(file.getName());
				}else {
					String suffix=getFileSuffix(file);
					for (int i = 0; i < p_extName.length; i++) {
						if (p_extName[i].equalsIgnoreCase(suffix)) {
						
							fileNames.add(file.getName());
						}
					}
				}
			}
			
		}
		return fileNames;
		
	}
	/**
	 * 返回文件后缀名
	 * @param file 文件
	 * @return
	 */
	public static String getFileSuffix(File file) {
		 try {
			String s[] = file.getCanonicalPath().split("\\.");
			return s[s.length - 1];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "";
	}
	/**
	 * 对目录下的文件名进行排序
	 * @param pathname 目录
	 * @param flag	true升序  flase降序
	 * @return
	 */
	public static List<String>  sortFileByName(String pathname,final boolean flag ){
		List<String> fileNames=Arrays.asList(new File(pathname).list());
		Collections.sort(fileNames,new Comparator<String>() {

			public int compare(String o1, String o2) {
				if (flag) {
					return o1.compareTo(o2);
				}else {
					return -o1.compareTo(o2);
				}
				
			}
		});
		return fileNames;
	}
	
	//-----------------------------------------
	/**
	 * 返回文件编码格式
	 * @param file
	 * @return
	 */
	public String getFileEncoding(File file){
		return null;
		
	}
	/**
	 * 读取温江 并转化为字符串 
	 * @param file
	 * @return
	 */
	public static String readFile(File file){
		byte[] bytes = readFileByte(file);
		return new String(bytes);
			   
	}
	/**
	 * 将字符串形式的文件写入文件
	 * @param str
	 * @param tagFile
	 */
	public static void writeFile(String str,File tagFile){
		byte[] bytes=str.getBytes();
		FileOutputStream outputStream=null;
		try {
			outputStream = new FileOutputStream(tagFile);
			outputStream.write(bytes);
		    outputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	       
	}
	/**
	 * 将字节写入文件
	 * @param bytes
	 * @param tagFile
	 */
	public static void writeFile(byte[] bytes,File tagFile){
		
		FileOutputStream outputStream=null;
		try {
			outputStream = new FileOutputStream(tagFile);
			outputStream.write(bytes);
		    outputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	       
	}
}
