/*
 * Copyright 2019 Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es
 */
public class Main {

    public static final Random RND = new Random();

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {

        //Limites Dia
        final int H_MIN = 0;
        final int M_MIN = 0;

        final int H_MAX = 23;
        final int M_MAX = 59;

        //Atencion Bancaria
        final int H_INI = 10;
        final int M_INI = 30;
        final int TMP_INI = H_INI * 60 + M_INI;
        final int H_FIN = 12;
        final int M_FIN = 15;
        final int TMP_FIN = H_FIN * 60 + M_FIN;

        //Hora aleatoria
        int hRnd = RND.nextInt(H_MAX - H_MIN + 1) + H_MIN;
        int mRnd = RND.nextInt(M_MAX - M_MIN + 1) + M_MIN;
        int tmpRnd = hRnd * 60 + mRnd;

        //Hora usuario
        int hUsr;
        int mUsr;
        int tmpUsr;

        try {
            System.out.print("Hora actual .......................: ");
            hUsr = SCN.nextInt();

            System.out.print("Minuto actual .....................: ");
            mUsr = SCN.nextInt();

            tmpUsr = hUsr * 60 + mUsr;

            System.out.printf("Hora aleatoria ....................: %02d:%02d%n", hRnd, mRnd);

            System.out.printf("Atención al cliente ...............: %s%n",
                    tmpRnd >= TMP_INI && tmpRnd <= TMP_FIN ? "Atención SI Disponible" : "Atención NO Disponible");

            System.out.printf("Hora actual .......................: %02d:%02d%n", hUsr, mUsr);

            System.out.printf("Atención al cliente ...............: %s%n",
                    tmpUsr >= TMP_INI && tmpUsr <= TMP_FIN ? "Atención SI Disponible" : "Atención NO Disponible");

        } catch (Exception e) {
            System.out.println("ERROR: Entrada incorrecta");
        } finally {
            SCN.nextLine();
        }
    }

}
