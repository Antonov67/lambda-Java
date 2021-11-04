package com.company;

public class Main {

    public static void main(String[] args) {
        QuadEquation quadEq;
        //опишем лямбда-выражение для поиска корней
        quadEq = (double a, double b, double c) -> {
            double d = b*b - 4*a*c; // дискриминант

            if (d>=0) {
                // Найти корни
                SolutionQuadEquation roots = new SolutionQuadEquation();
                roots.x1 = (-b-Math.sqrt(d))/(2*a);
                roots.x2 = (-b+Math.sqrt(d))/(2*a);
                return roots;
            }
            else
                return null;
        };
        //решим конкретное уравнение
        SolutionQuadEquation roots = quadEq.solve(1,-5,1);
        if (roots==null)
        System.out.println("Корней нет");
    else
        {
            System.out.println("x1 = " + roots.x1);
            System.out.println("x2 = " + roots.x2);
        }
    }
}
//объявим функциональный интерфейс
@FunctionalInterface
interface QuadEquation{
    SolutionQuadEquation solve(double a, double b, double c);
}
//решение квадратного уравнения - пара чисел
class SolutionQuadEquation{
    double x1;
    double x2;
}