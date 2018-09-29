
package in.blogspot.shrikworld.readempdetails;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="contrasena" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Emp" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Salary" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usuario",
    "contrasena",
    "emp"
})
@XmlRootElement(name = "EmpDetails")
public class EmpDetails {

    @XmlElement(required = true)
    protected String usuario;
    @XmlElement(required = true)
    protected String contrasena;
    @XmlElement(name = "Emp", required = true)
    protected List<EmpDetails.Emp> emp;

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Gets the value of the contrasena property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Sets the value of the contrasena property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasena(String value) {
        this.contrasena = value;
    }

    /**
     * Gets the value of the emp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmpDetails.Emp }
     * 
     * 
     */
    public List<EmpDetails.Emp> getEmp() {
        if (emp == null) {
            emp = new ArrayList<EmpDetails.Emp>();
        }
        return this.emp;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Salary" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "firstName",
        "lastName",
        "age",
        "dob",
        "salary"
    })
    public static class Emp {

        @XmlElement(name = "FirstName", required = true)
        protected String firstName;
        @XmlElement(name = "LastName", required = true)
        protected String lastName;
        @XmlElement(name = "Age")
        protected int age;
        @XmlElement(name = "DOB", required = true)
        protected String dob;
        @XmlElement(name = "Salary")
        protected int salary;

        /**
         * Gets the value of the firstName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Sets the value of the firstName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstName(String value) {
            this.firstName = value;
        }

        /**
         * Gets the value of the lastName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Sets the value of the lastName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastName(String value) {
            this.lastName = value;
        }

        /**
         * Gets the value of the age property.
         * 
         */
        public int getAge() {
            return age;
        }

        /**
         * Sets the value of the age property.
         * 
         */
        public void setAge(int value) {
            this.age = value;
        }

        /**
         * Gets the value of the dob property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOB() {
            return dob;
        }

        /**
         * Sets the value of the dob property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOB(String value) {
            this.dob = value;
        }

        /**
         * Gets the value of the salary property.
         * 
         */
        public int getSalary() {
            return salary;
        }

        /**
         * Sets the value of the salary property.
         * 
         */
        public void setSalary(int value) {
            this.salary = value;
        }

    }

}
