/*
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.test.query;

import org.ballerinalang.test.BCompileUtil;
import org.ballerinalang.test.BRunUtil;
import org.ballerinalang.test.CompileResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This contains methods to test nested query expressions with parameters from the enclosing function.
 *
 * @since Swan Lake
 */
public class NestedQueriesWithEnclFuncParams {

    private CompileResult result;

    @BeforeClass
    public void setup() {
        result = BCompileUtil.compile("test-src/query/queries_with_encl_func_params.bal");
    }

    @Test(dataProvider = "methodsToTest", description = "test closures inside queries")
    public void testEnclFuncParamsInQueries(String functionName) {
        BRunUtil.invoke(result, functionName);
    }

    @DataProvider
    public Object[] methodsToTest() {
        return new Object[]{
                "testFuncParams1",
                "testFuncParams2",
                "testFuncParams3",
                "testFuncParams4",
                "testFuncParams5"
        };
    }

    @AfterClass
    public void tearDown() {
        result = null;
    }
}
