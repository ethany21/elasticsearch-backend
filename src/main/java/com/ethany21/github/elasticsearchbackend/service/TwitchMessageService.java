package com.ethany21.github.elasticsearchbackend.service;

import com.ethany21.github.elasticsearchbackend.document.TwitchMessage;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TwitchMessageService {

    private final ElasticsearchOperations elasticsearchOperations;

    public List<TwitchMessage> getStreamer(String streamer) {

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("streamer", streamer))
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC))
                .withPageable(PageRequest.of(0, 50)).build();

        return elasticsearchOperations.search(nativeSearchQuery, TwitchMessage.class)
                .stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

}
