package pkg.goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FUO {


	public void mtdUpload(HttpServletRequest req, DTO dto) {
		
		String saveFolder = "D:\\Java_Web_AI\\silsp\\jsp\\p10_QD_Store\\src\\main\\webapp\\fileStorage";
		
		int maxSize = 5*1024*1024;   // 5MByte 까지 최대 업로드 허용
		String encType = "UTF-8";
		
		try {
			MultipartRequest multiReq = new MultipartRequest(
					req,
					saveFolder,
					maxSize,
					encType,
					new DefaultFileRenamePolicy()
					);
			// 파일 업로드 완료
			
			// DTO 초기화
			dto.setOriFName(multiReq.getOriginalFileName("fileName"));
			dto.setUpFName(multiReq.getFilesystemName("fileName"));
			dto.setGoodsName(multiReq.getParameter("goodsName"));
			dto.setPrice(Integer.parseInt(multiReq.getParameter("price")));
			dto.setContent(multiReq.getParameter("content"));
			dto.setRemoteIP(req.getRemoteAddr());
			
			
		} catch (IOException e ) {
			System.out.print("IOE : " + e.getMessage());
		}
	}
	

}
