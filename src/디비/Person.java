package 디비;


/*
    각 변수 이름이 DB의 이름과 일치해야 합니다 (대소문자 구문 안한다는 가정하에)
    set 메소드를 이용하여 데이터를 삽입 합니다
*/
public class Person {
    private String person_name
            , person_gender
            , person_age
            ;

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_gender() {
        return person_gender;
    }

    public void setPerson_gender(String person_gender) {
        this.person_gender = person_gender;
    }

    public String getPerson_age() {
        return person_age;
    }

    public void setPerson_age(String person_age) {
        this.person_age = person_age;
    }

    // 값이 잘 들어갔는지 확인 하기 위한 메소드 입니다
    @Override
    public String toString() {
        return "Person{" +
                "person_name='" + person_name + '\'' +
                ", person_gender='" + person_gender + '\'' +
                ", person_age='" + person_age + '\'' +
                '}';
    }
}
