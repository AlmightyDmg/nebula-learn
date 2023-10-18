package com.dmg.nebulalearn.model.edge;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.Table;

@Data
@Table(name = "like")
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    private Double likeness;
}
