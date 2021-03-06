/*
 * ProGuardCORE -- library to process Java bytecode.
 *
 * Copyright (c) 2002-2020 Guardsquare NV
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package proguard.classfile.constant;

import proguard.classfile.*;
import proguard.classfile.constant.visitor.ConstantVisitor;

/**
 * This {@link Constant} represents a module constant in the constant pool.
 *
 * @author Joachim Vandersmissen
 */
public class ModuleConstant extends Constant
{
    public int u2nameIndex;


    /**
     * Creates an uninitialized ModuleConstant.
     */
    public ModuleConstant()
    {
    }


    /**
     * Creates a new ModuleConstant with the given name index.
     * @param u2nameIndex the index of the name in the constant pool.
     */
    public ModuleConstant(int u2nameIndex)
    {
        this.u2nameIndex = u2nameIndex;
    }


    /**
     * Returns the name.
     */
    public String getName(Clazz clazz)
    {
        return clazz.getString(u2nameIndex);
    }


    // Implementations for Constant.

    public int getTag()
    {
        return Constant.MODULE;
    }

    public void accept(Clazz clazz, ConstantVisitor constantVisitor)
    {
        constantVisitor.visitModuleConstant(clazz, this);
    }
}
