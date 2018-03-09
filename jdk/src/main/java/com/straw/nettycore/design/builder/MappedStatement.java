package com.straw.nettycore.design.builder;

/**
 * @author fengzy
 * @date 3/9/2018
 */
public class MappedStatement {
    private int a;
    private int b;
    private int c;
    public MappedStatement() {
        // constructor disabled
    }

    private MappedStatement(Builder builder) {
        a = builder.a;
        b = builder.b;
        c = builder.c;
    }

    public static class Builder {
        MappedStatement mappedStatement = new MappedStatement();
        private int a;
        private int b;
        private int c;

        public Builder() {
            this.mappedStatement = mappedStatement;
        }

        public MappedStatement build() {
            return mappedStatement;
        }

        public Builder a(int val) {
            a = val;
            return this;
        }

        public Builder b(int val) {
            b = val;
            return this;
        }

        public Builder c(int val) {
            c = val;
            return this;
        }
    }
}

