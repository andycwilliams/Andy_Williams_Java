package com.company.MonthAPI.model;

import java.util.Objects;

public class MathSolution {

    private int id;
    private Integer operand1;
    private Integer operand2;
    private String operation;
    private Integer answer;

    public MathSolution(int id, Integer operand1, Integer operand2, String operation, Integer answer) {
        this.id = id;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }

    public MathSolution(Integer operand1, Integer operand2, String operation, Integer answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }

    public MathSolution() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }


    public int addInt(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int subtractInt(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int multiplyInt(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public int divideInt(int operand1, int operand2) {
        return operand1 / operand2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return id == that.id && Objects.equals(operand1, that.operand1) && Objects.equals(operand2, that.operand2) && Objects.equals(operation, that.operation) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operand1, operand2, operation, answer);
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "id=" + id +
                ", operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation='" + operation + '\'' +
                ", answer=" + answer +
                '}';
    }
}

//    switch(operand1, operand2) {
//        case add:
//            System.out.println(operand1 + operand2);
//            return operand1 + operand2;
//            break;
//        case subtract:
//            System.out.println(operand1 - operand2);
//            return operand1 - operand2;
//            break;
//        case multiply:
//            System.out.println(operand1 * operand2);
//            return operand1 * operand2;
//            break;
//        case divide:
//            System.out.println(operand1/operand2);
//            return operand1/operand2;
//            break;
//        default:
//            System.out.println("An error occurred");
//    }
