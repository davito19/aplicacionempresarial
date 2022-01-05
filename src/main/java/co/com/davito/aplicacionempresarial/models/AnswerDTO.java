package co.com.davito.aplicacionempresarial.models;

import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Optional;

public class AnswerDTO {

    @NotBlank(message =  "Debe existir el userID para este objeto")
    private String UserId;
    @NotBlank
    private String questionId;
    @NotBlank
    private String answer;
    private  Integer position;

    public AnswerDTO() {
    }

    public AnswerDTO(@NotBlank String userId, @NotBlank String questionId, @NotBlank String answer) {
        this.UserId = userId;
        this.questionId = questionId;
        this.answer = answer;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getPosition() {
        return Optional.ofNullable(position).orElse(1);
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerDTO answerDTO = (AnswerDTO) o;
        return Objects.equals(UserId, answerDTO.UserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId);
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "UserId='" + UserId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
