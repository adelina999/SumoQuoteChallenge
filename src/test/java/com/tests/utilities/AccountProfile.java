package com.tests.utilities;

import lombok.*;



    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class AccountProfile {


        @Setter @Getter String orgName;
        @Setter @Getter String firstName;
        @Setter @Getter String lastName;
        @Setter @Getter String email;
        @Setter @Getter String password;
        @Setter @Getter String phoneNumber;

        public AccountProfile getAccountProfile() {
            return this;
        }
    }


