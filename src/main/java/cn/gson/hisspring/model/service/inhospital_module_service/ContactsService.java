package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.ContactsMapper;
import cn.gson.hisspring.model.pojos.ZyContacts;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactsService {
    @Autowired
    ContactsMapper cm;//联系人mapper


    /**
     * 新增联系人
     * @param contacts
     * @return
     */
    public boolean insertContacts(ZyContacts contacts){
        int i = 0;
        if(contacts.getCtsId() == 0){
            cm.insert(contacts);
        }else{
            cm.updateById(contacts);
        }
        return i > 0 ? true : false;
    }

    public boolean deleteContacts(Long ctsId){
        int i = cm.deleteById(ctsId);
        return i > 0 ? true : false;
    }


    /**
     * 根据住院号循环新增联系人
     * @param list 联系人集合
     * @param ptNo 住院号
     * @return
     */
    public int insertContactsList(List<ZyContacts> list, Long ptNo){
      return cm.insertContactsList(list,ptNo);
    }


    /**
     * 根据病人住院号查询病人联系人
     */
    public List<ZyContacts> selectContactsByPtId(Long ptNo){
        QueryWrapper<ZyContacts> qw = new QueryWrapper<>();
        qw.eq("pt_no",ptNo);
        return cm.selectList(qw);
    }
}
