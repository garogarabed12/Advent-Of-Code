package aoc2020.day8;

import java.util.Objects;

public class Instruction {

    private String operation;
    private final int argument;

    public Instruction(String operation, int argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public String getOperation() {
        return operation;
    }

    public int getArgument() {
        return argument;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "operation='" + operation + '\'' +
                ", argument=" + argument +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return argument == that.argument && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, argument);
    }
}
