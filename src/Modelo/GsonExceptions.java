package Modelo;

import com.google.gson.annotations.SerializedName;

public class GsonExceptions {

    public static class Moeda {
        @SerializedName("moeda")
        public String CEP;  // Java ainda usa maiúsculo, mas vai mapear certinho

        // ... outros atributos e métodos
    }

}
