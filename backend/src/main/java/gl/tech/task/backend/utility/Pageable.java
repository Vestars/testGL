package gl.tech.task.backend.utility;

import org.springframework.data.domain.Page;

import java.util.List;

public class Pageable<T> {
    private List<T> content;
    private Boolean first;
    private Boolean last;
    private Integer pageSize;
    private Integer pageNumber;
    private Boolean empty;
    private Integer totalPages;
    private Long totalElements;

    public Pageable() {
    }

    public Pageable(List<T> content, Boolean first, Boolean last, Integer pageSize, Integer pageNumber, Boolean empty, Integer totalPages, Long totalElements) {
        this.content = content;
        this.first = first;
        this.last = last;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.empty = empty;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public static <T> Pageable<T> buildPageableResponse(final Page<T> pageObject){
        return new Pageable<T>(pageObject.getContent(), pageObject.isFirst(), pageObject.isLast(),
                pageObject.getSize(), pageObject.getPageable().getPageNumber() + 1, pageObject.isEmpty(),
                pageObject.getTotalPages(), pageObject.getTotalElements());
    }
}

