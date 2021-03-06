<p align="center">
  <img src="Picture1.png" />
</p>
<p align="center" style ="font-size: 24px"><em>Факультет мехатроники и робототехники</em></p>

<p align="center" style ="font-size: 24px"><strong>Лабораторная работа №1 </br>
По дисциплине : «Программирование»</br>
Вариант 336228</strong>
</p>
<p align="left">Преподаватель: <strong>Райла Мартин</strong></br>
Выполнил: <strong>Нгуен Тоан</strong></br>
Группа: <strong>R3137</strong>
</p>

# Лабораторная работа #1

## 1. Текст задания.

Написать программу на языке Java, выполняющую соответствующие варианту действия. Программа должна соответствовать следующим требованиям:

1. Она должна быть упакована в исполняемый jar-архив.
2. Выражение должно вычисляться в соответствии с правилами вычисления математических выражений (должен соблюдаться порядок выполнения действий и т.д.).
3. Программа должна использовать математические функции из стандартной библиотеки Java.
4. Результат вычисления выражения должен быть выведен в стандартный поток вывода в заданном формате.

Выполнение программы необходимо продемонстрировать на сервере `helios`.

Введите вариант: <span style="font-size:20px"><strong>`336228`</strong></span>

1. Создать одномерный массив a типа short. Заполнить его чётными числами от `2` до `20` включительно в порядке возрастания.
2. Создать одномерный массив x типа double. Заполнить его 14-ю случайными числами в диапазоне от `-4.0` до `6.0`.
3. Создать двумерный массив a размером `10x14`. Вычислить его элементы по следующей формуле (где `x = x[j]`)
   - если `a[i] = 2`, то  ![a[i][j] =\sin((\frac{\frac{2}{3}}{\ln(x)+1})^2)](https://latex.codecogs.com/gif.latex?a%5Bi%5D%5Bj%5D%20%3D%5Csin%28%28%5Cfrac%7B%5Cfrac%7B2%7D%7B3%7D%7D%7B%5Cln%28x%29&plus;1%7D%29%5E2%29)
   - если ![a[i] \in \{4, 12, 14, 16, 18\}](https://latex.codecogs.com/gif.latex?a%5Bi%5D%20%5Cin%20%5C%7B4%2C%2012%2C%2014%2C%2016%2C%2018%5C%7D), то ![a[i][j]=(\frac{(\sin(x))^{(\frac{x}{x+1})^3}+ \pi}{0.5})^2](https://latex.codecogs.com/gif.latex?a%5Bi%5D%5Bj%5D%3D%28%5Cfrac%7B%28%5Csin%28x%29%29%5E%7B%28%5Cfrac%7Bx%7D%7Bx&plus;1%7D%29%5E3%7D&plus;%20%5Cpi%7D%7B0.5%7D%29%5E2)
   - для остальных значений `a[i]`: ![a[i][j]= \arcsin(e^{(\sqrt[3]{-e^{x}}})^{2})](https://latex.codecogs.com/gif.latex?a%5Bi%5D%5Bj%5D%3D%20%5Carcsin%28e%5E%7B%28%5Csqrt%5B3%5D%7B-e%5E%7Bx%7D%7D%7D%29%5E%7B2%7D%29)
4. Напечатать полученный в результате массив в формате с тремя знаками после запятой.

## 2. Исходный код программы.
```java
import static java.lang.Math.*;

public class hello {

    /** Laboratory 1:
    * @author: Nguyen Toan
    */
    public static double random0to1() {
        double num = random()*(1+0.001);
        while (num >1) {
            num = random()*(1+0.001);
        }
        return num;
    }

    public static void main(String[] args){
    	// Initialize variables
        short[] evenNumbers = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        double[] doubleNumbers = new double[14];
        for (int i = 0; i < 14; i++) {
            doubleNumbers[i] = random0to1()*10 - 4;
        }

        double[][] resultNumbers = new double[10][14];

        // Main caculation 
        for (int i = 0; i < evenNumbers.length; i++) {
            for (int j = 0; j < 14; j++) {
                if (evenNumbers[i] == 2){
                    resultNumbers[i][j] = sin( pow((((double) 2/3) / (log(abs(doubleNumbers[j]))  +1)), 2) );
                } 
                else if (evenNumbers[i] == 2|| evenNumbers[i] == 12 || evenNumbers[i] == 14 || evenNumbers[i] == 16 || evenNumbers[i] == 18) {
                    resultNumbers[i][j] = pow( (pow(sin(doubleNumbers[j]),pow((double) doubleNumbers[j]/(doubleNumbers[j]-1), 3)) + PI) / 0.5 , 2);
                } 
                else {
                    resultNumbers[i][j] = asin( pow( exp(cbrt(-exp(doubleNumbers[j]))), 2) );
                }
            }
        }

        // Print output
        System.out.print("[");
        for (int i = 0; i < 10; i++) {
            System.out.print("[");

            for (int j = 0; j < 14; j++) {
                System.out.printf("%.3f\t", resultNumbers[i][j]);
            }
            if (i == 9) {
            	System.out.print("]]");
            	break;
            }
            System.out.println("],");
        }
    }
}
```

## 3. Результат работы программы.
```java
[[0,171 0,420   0,146   0,093   0,107   0,166   0,165   0,058   0,111   0,105   0,083   0,268   0,926   0,097   ],
[0,345  0,242   0,380   0,003   0,476   0,351   0,352   0,000   0,007   0,483   0,594   0,045   0,204   0,515   ],
[0,345  0,242   0,380   0,003   0,476   0,351   0,352   0,000   0,007   0,483   0,594   0,045   0,204   0,515   ],
[0,345  0,242   0,380   0,003   0,476   0,351   0,352   0,000   0,007   0,483   0,594   0,045   0,204   0,515   ],
[0,345  0,242   0,380   0,003   0,476   0,351   0,352   0,000   0,007   0,483   0,594   0,045   0,204   0,515   ],
[NaN    NaN     NaN     NaN     NaN     NaN     NaN     NaN     40,201  NaN     60,233  42,536  NaN     NaN     ],
[NaN    NaN     NaN     NaN     NaN     NaN     NaN     NaN     40,201  NaN     60,233  42,536  NaN     NaN     ],
[NaN    NaN     NaN     NaN     NaN     NaN     NaN     NaN     40,201  NaN     60,233  42,536  NaN     NaN     ],
[NaN    NaN     NaN     NaN     NaN     NaN     NaN     NaN     40,201  NaN     60,233  42,536  NaN     NaN     ],
[0,345  0,242   0,380   0,003   0,476   0,351   0,352   0,000   0,007   0,483   0,594   0,045   0,204   0,515   ]]
```

## 4. Выводы по работе.
Я вспомнила синтаксис и базовые операции в языке Java. Научилась компилировать программу с помощью команды javac которая генерирует файл с байт-кодом. А потом создавать и запускать jar-файл на сервере. Также изучила некоторые команды для ориентирования на сервере и для работы с файлами и директориями на нем.
