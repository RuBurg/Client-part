package com.example.myapplication.DB;

public class clientModel {

        private int id;
        private String first_name;
        private String second_name;
        private String phone_number;
        private String goal;
        private int age;
        private String notes_about_client;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getSecond_name() {
            return second_name;
        }

        public void setSecond_name(String second_name) {
            this.second_name = second_name;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getGoal() {
            return goal;
        }

        public void setGoal(String goal) {
            this.goal = goal;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getNotes_about_client() {
            return notes_about_client;
        }

        public void setNotes_about_client(String notes_about_client) {
            this.notes_about_client = notes_about_client;
        }

        @Override
        public String toString() {
            return "client{" +
                    "id=" + id +
                    ", first_name='" + first_name + '\'' +
                    ", second_name='" + second_name + '\'' +
                    ", phone_number='" + phone_number + '\'' +
                    ", goal='" + goal + '\'' +
                    ", age=" + age +
                    ", notes_about_client='" + notes_about_client + '\'' +
                    '}';
        }
    }