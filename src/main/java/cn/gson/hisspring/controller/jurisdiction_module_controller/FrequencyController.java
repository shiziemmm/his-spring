package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Frequency;
import cn.gson.hisspring.model.service.jurisdiction_module_service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class FrequencyController {
    @Autowired
    FrequencyService fs;

//    @RequestMapping("select-fre")
//    public List<Frequency> selectAll(){
//        return fs.selectAll();
//    }

    /**
     *
     * @param
     * @return 新增班次
     */
    @RequestMapping("add-fre")
    public int addFre(Frequency frequency){
        int i=fs.addFre(frequency);
        if(i>0){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     *
     * @param frequency
     * @return 编辑班次
     */
    @RequestMapping("edit-fre")
    public int editFre(Frequency frequency){
        int i= fs.editFre(frequency);
        if(i>0){
            return 1;
        }else{
            return 0;
        }
    }
//    /**
//     * 删除班次
//     */
//    @RequestMapping("delet-fre")
//    public int deletFre(Integer fid){
//        List<Frequency> list=fs.selectById(fid);
//        System.out.println(list);
//        if(list.get(0).getFZt()==0){
//            int i=fs.deletFre(fid);
//            return 0;
//        }else {
//            return 1;
//        }
//    }
}
