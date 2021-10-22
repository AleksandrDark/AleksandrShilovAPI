package dto;

import lombok.Data;

@Data
public class BoardTrelloDTO {
    private String id;
    private String name;
    private String desc;
    private boolean closed;
    private String idEnterprise;
    private boolean pinned;
    private String url;
    private String shortUrl;
    private String idOrganization;
}
