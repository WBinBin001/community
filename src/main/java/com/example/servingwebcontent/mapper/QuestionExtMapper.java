package com.example.servingwebcontent.mapper;
import com.example.servingwebcontent.model.Question;
import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);

}

