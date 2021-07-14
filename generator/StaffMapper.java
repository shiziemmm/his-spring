package generator;

import generator.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}