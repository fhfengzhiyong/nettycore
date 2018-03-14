package com.straw.nettycore.tokenizer.fk.core;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

/**
 * @author fengzy
 * @date 3/13/2018
 */
public class FKAnalyzer extends Analyzer {

    private String separator;

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public FKAnalyzer() {
        this(" ");
    }

    public FKAnalyzer(String separator) {
        this.separator = separator;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer fkTokenizer = new FKTokenizer(this.separator);
        return new TokenStreamComponents(fkTokenizer);
    }
}
