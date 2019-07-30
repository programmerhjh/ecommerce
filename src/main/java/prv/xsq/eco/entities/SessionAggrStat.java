package prv.xsq.eco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 洪家豪
 *         Created by acer on 2019/6/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionAggrStat {
    private Long taskid;
    private Long session_count;
    private Double visit_length_1s_3s_ratio;
    private Double visit_length_4s_6s_ratio;
    private Double visit_length_7s_9s_ratio;
    private Double visit_length_10s_30s_ratio;
    private Double visit_length_30s_60s_ratio;
    private Double visit_length_1m_3m_ratio;
    private Double visit_length_3m_10m_ratio;
    private Double visit_length_10m_30m_ratio;
    private Double visit_length_30m_ratio;
    private Double step_length_1_3_ratio;
    private Double step_length_4_6_ratio;
    private Double step_length_7_9_ratio;
    private Double step_length_10_30_ratio;
    private Double step_length_30_60_ratio;
    private Double step_length_60_ratio;
}
