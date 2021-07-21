package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyContacts;
import cn.gson.hisspring.model.service.inhospital_module_service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 联系人controller
 */
@RestController
@CrossOrigin
public class ContactsController {

    @Autowired
    ContactsService cs;

    /**
     *新增或者修改联系人
     */
    @RequestMapping("insert-update-cts")
    public boolean insertContacts(@RequestBody ZyContacts contacts){
        System.out.println(contacts);
        return cs.insertContacts(contacts);
    }


    /**
     * 根据联系人删除数据
     */
    @RequestMapping("delete-cts")
    public boolean deleteContacts(Long ctsId){
        return cs.deleteContacts(ctsId);
    }

    /**
     * 根据病人住院号查询联系人
     * @param ptNo 病人住院号
     */
    @RequestMapping("select-byPtNo")
    public List<ZyContacts> selectContactsByPtId(Long ptNo){
        return cs.selectContactsByPtId(ptNo);
    }
}
