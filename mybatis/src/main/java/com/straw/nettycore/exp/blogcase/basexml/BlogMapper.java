package com.straw.nettycore.exp.blogcase.basexml;

import com.straw.nettycore.exp.blogcase.Blog;

/**
 * Created by Administrator on 9/6/2017.
 *
 */
public interface BlogMapper {
    Blog selectBlog(int id);
}
