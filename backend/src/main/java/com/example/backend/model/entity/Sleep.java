package com.example.backend.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Sleep")
public class Sleep {

    @EmbeddedId
    UserSleepKey userSleepKey;

    @NotEmpty
    private float duration;

    @Max(5)
    @Min(0)
    private int restScore;


    private boolean dream;

    private boolean alarmWakeUp;

    private int nNaps;

    public Sleep(UserSleepKey userSleepKey, float duration, int restScore, boolean dream, boolean alarmWakeUp, int nNaps) {
        this.userSleepKey = userSleepKey;
        this.duration = duration;
        this.restScore = restScore;
        this.dream = dream;
        this.alarmWakeUp = alarmWakeUp;
        this.nNaps = nNaps;
    }

    public boolean getDream() {
        return dream;
    }

    public boolean getAlarmWakeUp() {
        return alarmWakeUp;
    }
}
