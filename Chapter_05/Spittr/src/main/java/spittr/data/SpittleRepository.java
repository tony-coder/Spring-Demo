package spittr.data;

import spittr.domain.Spittle;

import java.util.List;

public interface SpittleRepository {
    /***
     *
     * @param max 返回的Spittle中，Spittle ID属性的最大值
     * @param count 返回多少个Spittle对象
     * @return Spittle列表
     */
    List<Spittle> findSpittles(long max, int count);
}
