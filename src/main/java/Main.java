package main.java;

import main.java.lesson_01.Lesson_01_Basics;
import main.java.lesson_02.Lesson_02_Implementing_methods_for_Interface;
import main.java.lesson_03.Lesson_03_Tasks_With_Strings_and_Arrays;
import main.java.lesson_04.Lesson_04_Implementing_DataStructures;
import main.java.lesson_05.Lesson_05_Basic_algorithm_tasks;
import main.java.lesson_06.Lesson_06_Tasks_with_HashMap;
import main.java.lesson_07.Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections;
import main.java.lesson_08.Lesson_08_Trees;
import main.java.lesson_09.Lesson_09_TreeMap_Jenerics;

/*
 * @Author: Andrii Yepanchyn
 *
 */


public class Main {
    public static void main(String[] args) {

    	String startMessage = Utils.wrapMessage("Here we start with Hillel homeworks", false, '=', '=', '\u0000');
        System.out.println(startMessage);
        Lesson_01_Basics.run();
        Lesson_02_Implementing_methods_for_Interface.run();
        Lesson_03_Tasks_With_Strings_and_Arrays.run();
        Lesson_04_Implementing_DataStructures.run();
        Lesson_05_Basic_algorithm_tasks.run();
        Lesson_06_Tasks_with_HashMap.run();
        Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections.run();
        Lesson_08_Trees.run();
        Lesson_09_TreeMap_Jenerics.run();

    }
}
