package com.wego.web.community;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.wego.web.admin.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public class Community {
    
    private String artSeq, rating, img, uid, comments, msg, boardType, title, content;
    
}
