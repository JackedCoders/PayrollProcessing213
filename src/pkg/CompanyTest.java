/**
 * 
 * @author Manveer Singh, Prasidh Sriram
 */
package pkg;

class CompanyTest {

    public void testAdd() {
        Company comp1 = new Company();
        Date date1 = new Date("01/12/2020");
        Profile newPerson = new Profile("John, Doe", "CS", date1);

        Employee parttime = new Parttime(newPerson, 24.3);

        assertTrue(comp1.add(parttime));
    }

    public void testRemove() {

    }

    public void testsetHours() {

    }
}