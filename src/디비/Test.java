package 디비;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        // DB 데이터라고 치고 Map 을 이용합니다
        Map<String, String> map = new HashMap<>();
        map.put("PERSON_NAME", "에비츄");
        map.put("PERSON_GENDER", "남자");
        map.put("PERSON_AGE", "19");

        Person person = (Person) 창주형메소드(map, Person.class);
        System.out.print(person);
    }

    /*
        요약 : DB 의 데이터를 가져와서 Object 에 값을 넣는 예제 입니다
               DB 를 대신하여 Map<String, String> 을 이용하겠습니다

        파라미터로 객체, 클래스 둘 중 하나를 받아서 작성 할 수 있는데 이번에는 클래스를 이용해보겠습니다
        map 의 데이터를 Person 클래스를 이용하여 값을 넣어 보겠습니다
     */
    public static Object 창주형메소드(Map<String, String> map, Class<?> cls) {
        // 값을 넣을 객체
        Object result = null;
        // 이 방법이 여러 많은 Exception 을 발생 시키기 때문에 try - catch 를 해줍니다
        try {
            /*
                result = Class.forName(cls.getCanonicalName()).newInstance();
                원래는 으로 사용했지만 deprecated 될 기능이기에 아래 코드로 대체 합니다

                객체를 생성하는 방법은 여러가지가 있는데
                 보편적으로 Person person = new Person(); 을 사용하고
                 클래스를 이용하여 객체를 생성하는 newInstance() 등 방법이 있습니다
                 ( 객체의 Class 의 이름을 추출하여 해당 객체를 사용할 때는 위 방법에 Class.forName() 기능을 추가 하면 됩니다 - 추후에 다룸)

                 getDeclaredConstructor()   // 클래스의 Declared 된 빈 () 생성자를 가져옵니다
                 .newInstance();    // 생성자를 이용하여 객체를 생성합니다
             */
            result = cls.getDeclaredConstructor().newInstance();

            for(String key : map.keySet()){                                  // Map 의 Key 값들을 불러옵니다
                for(Method method : cls.getDeclaredMethods()){               // Person.class 에 정의 된 Method 들을 불러옵니다
                    String method_name = method.getName().toUpperCase();     // 대소문자 관계 없이 key 와 method_name 을 비교하기 위해 toUpperCase() 를 사용합니다. ex) setPersonName -> SETPERSONNAME
                    if(method_name.contains("SET")){                         // SET 메소드 일 경우
                        method_name = method_name.replaceAll("SET",""); // method_name 에서 SET을 지웁니다 ex) SETPERSONNAME 일 경우 PERSONNAME
                        if(key.toUpperCase().equals(method_name)){
                            method.invoke(result, map.get(key));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}