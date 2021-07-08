package generator;

import generator.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer deId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer deId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}