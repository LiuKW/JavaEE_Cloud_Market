package com.vvlhw.supermarket.service.impl;

import com.vvlhw.supermarket.entity.Comment;
import com.vvlhw.supermarket.dao.CommentMapper;
import com.vvlhw.supermarket.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
