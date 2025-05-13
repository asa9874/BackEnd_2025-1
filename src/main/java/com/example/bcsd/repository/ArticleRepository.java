package com.example.bcsd.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bcsd.model.Article;
import com.example.bcsd.model.Board;
import com.example.bcsd.model.Member;

@Repository
public class ArticleRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    private static Long DEFAULT_ID = 0L;
    private List<Article> articles = new ArrayList<>(); // 데이터베이스 대용

    public ArticleRepository(BoardRepository boardRepository, MemberRepository memberRepository) {
        // 초기데이터 생성 (맴버, 게시판은 1로 고정)
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
        Board board = boardRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다."));
        save(new Article(board, member, "제목1", "내용1"));
        save(new Article(board, member, "제목2", "내용2"));
    }

    public Long getNextId() {
        return ++DEFAULT_ID;
    }

    public Optional<Article> findById(Long id) {
        String sql = "SELECT id, board_id, author_id, title, content, created_date, modified_date FROM article WHERE id = ?";
        Article article = jdbcTemplate.queryForObject(sql, articleRowMapper(), id);
        return Optional.ofNullable(article);
    }

    public List<Article> findAll() {
        String sql = "SELECT id, board_id, author_id, title, content, created_date, modified_date FROM article";
        List<Article> Articles = jdbcTemplate.query(sql, articleRowMapper());
        return Articles;
    }

    public List<Article> findByBoardId(Long boardId) {
        return articles.stream()
                .filter(article -> article.getBoard().getId().equals(boardId))
                .toList();
    }

    public void deleteById(Long id) {
        articles.removeIf(article -> article.getId().equals(id));
    }

    public void save(Article article) { // 저장(수정)
        if (article.getId() == null) {
            article.setId(getNextId()); // 생성
            article.setCreatedAt(LocalDateTime.now());
        } else {// 수정
            deleteById(article.getId());
            article.setUpdatedAt(LocalDateTime.now());
        }
        articles.add(article);
    }

    private RowMapper<Article> articleRowMapper() {
        return (resultSet, rowNum) -> new Article(
            resultSet.getLong("id"),
            boardRepository.findById(resultSet.getLong("board_id"))
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다.")),
            memberRepository.findById(resultSet.getLong("author_id"))
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다.")),
            resultSet.getString("title"),
            resultSet.getString("content"),
            resultSet.getTimestamp("created_date").toLocalDateTime(),
            resultSet.getTimestamp("modified_date").toLocalDateTime()
        );
    }
}
