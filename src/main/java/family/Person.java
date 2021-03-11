public class Person{
    private String gender;
    private String name;

    public Person(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

     /**
    * This method is used to validate gender of the person.
    * @param gender gender to be validated MALE OR FEMALE
    * @exception InvalidGenderException Thrown when gender is not a match
    * @return Nothing
    */
    public void validateGender(String gender) throws InvalidGenderException {
        if(!this.gender.equals(gender))
            throw new InvalidGenderException("Gender did not match");
    }
}