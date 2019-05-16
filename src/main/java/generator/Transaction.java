package generator;

import com.dailycount.configuration.ResponseData;
import com.dailycount.service.No1;
import com.dailycount.service.No2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName Transaction
 * @Description TODO
 * @Author cheng
 * @Date 2019/4/23 10:19
 **/
@Controller
public class Transaction {

    @Autowired
    No1 no1;

    @Autowired
    No2 no2;

    @RequestMapping(value = "/add",method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseData test(){
        no1.insert();
        no2.insert();
        return ResponseData.success();
    }



    /**
     * REQUIRED
     * 1.无事务调无事务，正常执行；无事务调有事务，有事务部分回滚
     * 2.有事务调（有/无）事务，一条异常则全部回滚
     * REQUIRES_NEW
     * 1.无事务调无事务，正常执行；无事务调有事务，有事务部分回滚
     * 2.
     */

}
