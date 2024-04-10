package sorenrahimi.g1s2m2.entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Author {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;
}
