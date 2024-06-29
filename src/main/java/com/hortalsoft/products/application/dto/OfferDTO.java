package com.hortalsoft.products.application.dto;

import com.hortalsoft.crosscutting.helper.ObjectHelper;
import com.hortalsoft.crosscutting.helper.TextHelper;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {
    @NotNull
    private Integer id;

    @NotNull(message = "El producto no puede ser nulo")
    private Integer productId;

    @NotNull(message = "El agricultor no puede ser nulo")
    private Integer farmerId;

    @Size(max = 500)
    @Builder.Default
    private String description = "";

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(1)
    private Integer amount;

    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double price;

    @NotNull(message = "La fecha inicial no puede ser nula")
    @FutureOrPresent
    private LocalDateTime initialDate;

    @NotNull(message = "La fecha final no puede ser nula")
    @FutureOrPresent
    private LocalDateTime finalDate;

    private boolean validity;
    private String idBlockchain;

    // Setters using helpers
    /*public void setId(Integer id) {
        this.id = ObjectHelper.getDefaultInteger(id);
    }*/

    public void setProductId(Integer productId) {
        this.productId = ObjectHelper.getDefaultInteger(productId);
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = ObjectHelper.getDefaultInteger(farmerId);
    }

    public void setDescription(String description) {
        this.description = TextHelper.getDefault(description);
    }

    public void setAmount(Integer amount) {
        this.amount = ObjectHelper.getDefaultInteger(amount);
    }

    public void setPrice(Double price) {
        this.price = ObjectHelper.isNull(price) ? 0.0 : price;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = ObjectHelper.isNull(initialDate) ? LocalDateTime.now() : initialDate;
    }

    public void setFinalDate(LocalDateTime finalDate) {
        this.finalDate = ObjectHelper.isNull(finalDate) ? LocalDateTime.now() : finalDate;
    }

    public void setIdBlockchain(String idBlockchain) {
        this.idBlockchain = TextHelper.getDefault(idBlockchain);
    }

    // Getters using helpers
    /*public Integer getId() {
        return ObjectHelper.getDefaultInteger(id);
    }*/

    public Integer getProductId() {
        return ObjectHelper.getDefaultInteger(productId);
    }

    public Integer getFarmerId() {
        return ObjectHelper.getDefaultInteger(farmerId);
    }

    public String getDescription() {
        return TextHelper.getDefault(description);
    }

    public Integer getAmount() {
        return ObjectHelper.getDefaultInteger(amount);
    }

    public Double getPrice() {
        return ObjectHelper.isNull(price) ? 0.0 : price;
    }

    public LocalDateTime getInitialDate() {
        return ObjectHelper.isNull(initialDate) ? LocalDateTime.now() : initialDate;
    }

    public LocalDateTime getFinalDate() {
        return ObjectHelper.isNull(finalDate) ? LocalDateTime.now() : finalDate;
    }

    public String getIdBlockchain() {
        return TextHelper.getDefault(idBlockchain);
    }
}

