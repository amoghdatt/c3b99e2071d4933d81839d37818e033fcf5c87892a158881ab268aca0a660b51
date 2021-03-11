package family;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import family.service.relationship.RelationshipManager;
import family.service.membership.MembershipManager;

public class App {

  public static MembershipManager membershipManager;
  public static RelationshipManager relationshipManager;

  public static void main(String[] args) {

    String fileName = args[0];
    Family shanFamily = initializeFamily("Shan");
    relationshipManager = new RelationshipManager(shanFamily);
    readFile(fileName, shanFamily);

  }

  private static Family initializeFamily(String familyHead) {
    Family family = new Family(familyHead);
    membershipManager = new MembershipManager(family);
    membershipManager.handleNewFamilyMember("", "Shan", "Male", "NEW_MEMBER");
    ArrayList<FamilyMember> children; 

    // shan and anga
    FamilyMember shan = new FamilyMember("Shan", "Male", null, null);
    family.addNewFamilyMember("Shan", shan);
    FamilyMember anga = new FamilyMember("Anga", "Female", null, null);
    shan.setSpouse(anga);
    anga.setSpouse(shan);
    children = new ArrayList<>();
    anga.setChildren(children);
    shan.setChildren(children);
    family.addNewFamilyMember("Anga", anga);


    //chit and amba
    FamilyMember chit = new FamilyMember("Chit", "Male", shan, anga);
    FamilyMember amba = new FamilyMember("Amba", "Female", null, null);
    chit.setSpouse(amba);
    amba.setSpouse(chit);
    children = new ArrayList<>();
    chit.setChildren(children);
    amba.setChildren(children);
    family.addNewFamilyMember("Chit", chit);
    family.addNewFamilyMember("Amba", amba);
    anga.addChild(chit);


    //Vich and Lika
    FamilyMember vich = new FamilyMember("Vich", "Male", shan, anga);
    FamilyMember lika = new FamilyMember("Lika", "Female", null, null);
    vich.setSpouse(lika);
    lika.setSpouse(vich);
    children = new ArrayList<>();
    lika.setChildren(children);
    vich.setChildren(children);
    family.addNewFamilyMember("Vich", vich);
    family.addNewFamilyMember("Lika", lika);
    anga.addChild(vich);

    //ish
    FamilyMember ish = new FamilyMember("Ish", "Male", shan, anga);
    anga.addChild(ish);
    family.addNewFamilyMember("Ish", ish);

    // Aras and chitra
    FamilyMember aras = new FamilyMember("Aras", "Male", shan, anga);
    family.addNewFamilyMember("Aras", aras);
    FamilyMember chitra = new FamilyMember("Chitra", "Female", null, null);
    chitra.setSpouse(aras);
    aras.setSpouse(chitra);
    children = new ArrayList<>();
    aras.setChildren(children);
    chitra.setChildren(children);
    family.addNewFamilyMember("Chitra", chitra);
    family.addNewFamilyMember("Aras", aras);
    anga.addChild(aras);
    
    // Satya and Vyan
    FamilyMember satya = new FamilyMember("Satya", "Female", shan, anga);
    FamilyMember vyan = new FamilyMember("Vyan", "Male", null, null);
    satya.setSpouse(vyan);
    vyan.setSpouse(satya);
    children = new ArrayList<>();
    satya.setChildren(children);
    vyan.setChildren(children);
    family.addNewFamilyMember("Satya", satya);
    family.addNewFamilyMember("Vyan", vyan);
    anga.addChild(satya);

    //Dritha and Jaya
    FamilyMember dritha = new FamilyMember("Dritha", "Female", chit, amba);
    FamilyMember jaya = new FamilyMember("Jaya", "Male", null, null);
    dritha.setSpouse(jaya);
    jaya.setSpouse(dritha);
    children = new ArrayList<>();
    dritha.setChildren(children);
    jaya.setChildren(children);
    family.addNewFamilyMember("Dritha", dritha);
    family.addNewFamilyMember("Jaya", jaya);
    amba.addChild(dritha);
    FamilyMember tritha = new FamilyMember("Tritha", "Female", chit, amba);
    FamilyMember vritha = new FamilyMember("Vritha", "Mmale", chit, amba);
    amba.addChild(tritha);
    amba.addChild(vritha);
    family.addNewFamilyMember("Thritha", tritha);
    family.addNewFamilyMember("Vritha", vritha);


    

    //arit and jnki
    FamilyMember arit = new FamilyMember("Arit", "Male", null, null);
    FamilyMember jnki = new FamilyMember("Jnki", "Female", aras, chitra);
    arit.setSpouse(jnki);
    jnki.setSpouse(arit);
    children = new ArrayList<>();
    jnki.setChildren(children);
    arit.setChildren(children);
    family.addNewFamilyMember("Arit", arit);
    family.addNewFamilyMember("Jnki", jnki);
    chitra.addChild(jnki);
    FamilyMember ahit = new FamilyMember("Ahit", "Male", aras, chitra);
    chitra.addChild(ahit);
    family.addNewFamilyMember("Ahit", ahit);

    // Satvy and asva
    FamilyMember satvy = new FamilyMember("Satvy", "Female", null, null);
    FamilyMember asva = new FamilyMember("Asva", "Male", vyan, satya);
    satvy.setSpouse(asva);
    asva.setSpouse(satvy);
    children = new ArrayList<>();
    satvy.setChildren(children);
    asva.setChildren(children);
    family.addNewFamilyMember("Satvy", satvy);
    family.addNewFamilyMember("Asva", asva);
    satya.addChild(asva);
    

    //krpi and vyas
    FamilyMember krpi = new FamilyMember("Krpi", "Female", null, null);
    FamilyMember vyas = new FamilyMember("Vyas", "Male", vyan, satya);
    vyas.setSpouse(krpi);
    krpi.setSpouse(vyas);
    children = new ArrayList<>();
    vyas.setChildren(children);
    krpi.setChildren(children);
    family.addNewFamilyMember("Krpi", krpi);
    family.addNewFamilyMember("Vyas", vyas);
    satya.addChild(vyas);
    FamilyMember atya = new FamilyMember("Atya", "Female", vyan, satya);
    satya.addChild(atya);
    family.addNewFamilyMember("Atya", atya);

    //yodhan
    FamilyMember yodhan = new FamilyMember("Yodhan", "Male", jaya, dritha);
    family.addNewFamilyMember("Yodhan", yodhan);
    dritha.addChild(yodhan);

    //Laki
    FamilyMember laki = new FamilyMember("Yodhan", "Male", arit, jnki);
    family.addNewFamilyMember("Laki", laki);
    jnki.addChild(laki);


    //Lavnya
    FamilyMember lavnya = new FamilyMember("Lavnya", "Female", arit, jnki);
    family.addNewFamilyMember("Lavnya", lavnya);
    jnki.addChild(lavnya);

    //vasa
    FamilyMember vasa = new FamilyMember("Vasa", "Male", asva, satvy);
    family.addNewFamilyMember("Vasa", vasa);
    satvy.addChild(vasa);

    // kriya
    FamilyMember kriya = new FamilyMember("Kriya", "Male", vyas, krpi);
    family.addNewFamilyMember("Kriya", kriya);
    krpi.addChild(kriya);

    //krithi
    FamilyMember krithi = new FamilyMember("Krithi", "Female", vyas, krpi);
    family.addNewFamilyMember("Krithi", krithi);
    krpi.addChild(krithi);

       
    return family;
    }

    private static void readFile(String filename, Family family) {
        try {
          File myObj = new File(filename);
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] task = data.split(" ");
            handleFamilyTask(task, family);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }

    private static void handleFamilyTask(String[] task, Family family) {
        
        String givenTask = task[0];

        switch(givenTask){
            case "ADD_CHILD":
                String motherName = task[1];
                String childName = task[2];
                String childGender = task[3];

                membershipManager.handleNewFamilyMember(motherName, childName, childGender, "CHILD");
                break;
            case "GET_RELATIONSHIP":
                String memberName = task[1];
                String relationship = task[2];

                relationshipManager.handleRelationship(memberName, relationship);
                break;
        }
      }

    }
