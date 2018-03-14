package com.straw.nettycore.tokenizer.fk.core;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @author fengzy
 * @date 3/13/2018
 */
public final class FKTokenizer extends Tokenizer {
    protected String separator;
    protected String stringText;
    protected CharTermAttribute charTermAttribute = addAttribute(CharTermAttribute.class);
    //初始偏移量
    protected int position=0;

    public FKTokenizer() {
        this(" ");
    }

    public FKTokenizer(AttributeFactory factory, String separator) {
        super(factory);
        this.separator = separator;
    }

    public FKTokenizer(String separator) {
        super();
        this.separator = separator;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        this.position = 0;
    }


    @Override
    public boolean incrementToken() throws IOException {
        //清除所有的词元属性
        clearAttributes();
        if (StringUtils.isEmpty(stringText)) {
            this.stringText = transFromRander(input);
        }
        int nextToken = this.stringText.indexOf(this.separator,this.position);
        if (nextToken > 0) {
            String token = this.stringText.substring(this.position, nextToken);
            this.charTermAttribute.append(token);
            this.position = nextToken + 1;
            return true;
        }else if (this.position<this.stringText.length()){
            String token = this.stringText.substring(this.position, this.stringText.length());
            this.charTermAttribute.append(token);
            this.position = this.stringText.length();
            return true;
        }else{
            return false;
        }
    }

    private String transFromRander(Reader input){
        char[] bufferChar = new char[1024];
        StringBuilder sb = new StringBuilder();
        try {
            while (input.read(bufferChar) !=-1){
                sb.append(bufferChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.stringText = sb.toString();
        return this.stringText;
    }


}
