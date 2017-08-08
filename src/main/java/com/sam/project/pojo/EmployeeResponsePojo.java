package com.sam.project.pojo;

import java.io.Serializable;

/**
 * Created by sameer on 20/12/16.
 */
public class EmployeeResponsePojo implements Serializable {

        private String name;
        private String email;
        private String phone;

        public EmployeeResponsePojo(){

        }
        public EmployeeResponsePojo(String email,String name,String phone){
            this.email=email;
            this.name=name;
            this.phone=phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }



}
