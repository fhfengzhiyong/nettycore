package com.straw.nettycore.blogcase.basexml;

import com.straw.nettycore.blogcase.Blog;

/**
 * Created by Administrator on 9/6/2017.
 *
 */
public interface BlogMapper {
    Blog selectBlog(int id);
}
