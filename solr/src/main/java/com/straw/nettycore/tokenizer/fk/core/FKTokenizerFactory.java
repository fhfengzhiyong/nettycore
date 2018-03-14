package com.straw.nettycore.tokenizer.fk.core;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import java.util.Map;

/**
 * @author fengzy
 * @date 3/14/2018
 */
public class FKTokenizerFactory extends TokenizerFactory{

    /**
     * Initialize this factory via a set of key-value pairs.
     *
     * @param args
     */
    protected String separator = null;
    public FKTokenizerFactory(Map<String, String> args) {
        super(args);
        separator = args.get("separator");
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return new FKTokenizer(factory,separator);
    }
}
