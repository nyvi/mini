package com.mini.common.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author czk
 * @date 2017-12-10
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseDO {

    private String uname;

}
