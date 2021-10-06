public class Main {
    public static void main(String[] args) {
        PhysicalPerson physicalPerson = new PhysicalPerson();
        physicalPerson.put(543);
        System.out.println(physicalPerson.getAmount());
        physicalPerson.put(-1);
        System.out.println(physicalPerson.getAmount());

        LegalPerson legalPerson = new LegalPerson();
        legalPerson.put(500);
        System.out.println(legalPerson.getAmount());
        legalPerson.take(400);
        System.out.println(legalPerson.getAmount());

        IndividualBusinessman businessman = new IndividualBusinessman();
        businessman.put(900);
        System.out.println(businessman.getAmount());
        businessman.put(20000);
        System.out.println(businessman.getAmount());
    }
}
