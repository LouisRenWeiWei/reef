package com.microsoft.tang.implementation;

import java.util.Collection;
import java.util.Set;

import com.microsoft.tang.ClassHierarchy;
import com.microsoft.tang.Configuration;
import com.microsoft.tang.ConfigurationBuilder;
import com.microsoft.tang.ExternalConstructor;
import com.microsoft.tang.types.ClassNode;
import com.microsoft.tang.types.ConstructorDef;
import com.microsoft.tang.types.NamedParameterNode;
import com.microsoft.tang.util.MonotonicSet;

public class ConfigurationImpl implements Configuration {
  final ConfigurationBuilderImpl builder;

  protected ConfigurationImpl(final ConfigurationBuilderImpl builder) {
    this.builder = builder;
  }

  @Override
  public String getNamedParameter(final NamedParameterNode<?> np) {
    return builder.namedParameters.get(np);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> ClassNode<? extends ExternalConstructor<T>> getBoundConstructor(
      final ClassNode<T> cn) {
    return (ClassNode<? extends ExternalConstructor<T>>) builder.boundConstructors.get(cn);
  }

  @Override
  public Set<ClassNode<?>> getBoundImplementations() {
    return builder.boundImpls.keySet();
  }

  @Override
  public Set<ClassNode<?>> getBoundConstructors() {
    return builder.boundConstructors.keySet();
  }

  @Override
  public Set<NamedParameterNode<?>> getNamedParameters() {
    return builder.namedParameters.keySet();
  }

  @Override
  public Set<ClassNode<?>> getLegacyConstructors() {
    return builder.legacyConstructors.keySet();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> ClassNode<? extends T> getBoundImplementation(final ClassNode<T> cn) {
    return (ClassNode<? extends T>) builder.boundImpls.get(cn);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> ConstructorDef<T> getLegacyConstructor(final ClassNode<T> cn) {
    return (ConstructorDef<T>) builder.legacyConstructors.get(cn);
  }

  @Override
  public Collection<ClassNode<?>> getSingletons() {
    return new MonotonicSet<>(builder.singletons);
  }

  @Override
  public ConfigurationBuilder newBuilder() {
    return builder.build().builder;
  }
  
  @Override
  public ClassHierarchy getClassHierarchy() {
    return builder.namespace;
  }
}
