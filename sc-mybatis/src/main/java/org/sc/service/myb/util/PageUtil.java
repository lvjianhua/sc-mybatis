package org.sc.service.myb.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PageUtil <T> extends Result<T>{
    private long count;
}
