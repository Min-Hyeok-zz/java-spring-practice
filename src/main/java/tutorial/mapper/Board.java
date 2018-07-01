package tutorial.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface Board {

    @Select("SELECT * FROM board")
    List<HashMap<String, Object>> GetAll();

    @Select("SELECT * FROM board where idx = #{idx}")
    HashMap<String, Object> Get(int idx);

    @Insert("INSERT INTO board SET writer=#{writer}, subject=#{subject}, content=#{content}, hit=0, date=now()")
    void Insert(HashMap params);

    @Update("UPDATE board SET writer=#{writer}, subject=#{subject}, content=#{content} where idx = #{idx}")
    void Update(HashMap params);

    @Delete("DELETE FROM board where idx = #{idx}")
    void Delete(int idx);
}
