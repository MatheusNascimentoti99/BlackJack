/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Matheus Nascimento
 */
    public class Carta {

        private String value;
        private String naipe;

        public Carta(String value, String naipe) {
            this.value = value;
            this.naipe = naipe;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getNaipe() {
            return naipe;
        }

        public void setNaipe(String naipe) {
            this.naipe = naipe;
        }

        @Override
        public String toString() {
            return ("[Naipe:" + naipe + " Valor:" + value+"]");
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Carta other = (Carta) obj;
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return Objects.equals(this.naipe, other.naipe);
        }
        
    }
